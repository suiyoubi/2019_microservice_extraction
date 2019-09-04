
# Representative execution trace extraction

set -x
PROJECT=jforum219
OUTPUT=./${PROJECT}_outputs
mkdir $OUTPUT

# Generate workflow.csv for kieker_logs.dat
PROJECT_PACKAGE=net.jforum
WORKFLOW=${OUTPUT}/${PROJECT}_workflow
python traceWorkflow.py ./kieker_logs/$PROJECT ${WORKFLOW}.csv $PROJECT_PACKAGE

# Filter the workflow into different tiers: part1 = presentation logs, part2 = service logs, part2 = persistence
python workflowFilter.py ${WORKFLOW}.csv ${WORKFLOW}_part1.csv ${WORKFLOW}_part2.csv ${WORKFLOW}_part3.csv ${WORKFLOW}_allparts.csv

# Produce the representative execution trace set
TESTCASE_NAME=${OUTPUT}/${PROJECT}_testcase_name
python reduceWorkflow.py ${WORKFLOW}.csv ${WORKFLOW}_reduced.csv ${TESTCASE_NAME}.csv   

# Generate a file that holds all the class dependencies, based on the extracted execution traces
CLASS_DEPS=${OUTPUT}/${PROJECT}_class_dependencies
python classCallDep.py ${WORKFLOW}_reduced.csv ${CLASS_DEPS}.csv

# Generate classfilename file and featureVector file
TESTCASE=${OUTPUT}/${PROJECT}_testcase
python genTestCaseFv.py ${WORKFLOW}_reduced.csv ${TESTCASE_NAME}.csv null null ${TESTCASE}_class.csv ${TESTCASE}_fv.csv   

# Generate a file that holds all the concern dependencies, based on the extracted execution traces
CONCERN_DEPS=${OUTPUT}/${PROJECT}_concern_dependencies
python classConcernDep.py ${TESTCASE}_class.csv ${CONCERN_DEPS}.csv

# Generate a set of classes involved in each trace tri
CTR=${OUTPUT}/${PROJECT}_ctr
python groupClassByTrace.py ${TESTCASE}_fv.csv ${TESTCASE}_class.csv ${CTR}.csv  

# Initialize functional atoms s.t. Fa = { Ci } 
DIFF=3
ATOMS=${OUTPUT}/${PROJECT}_atoms
python functionLogicIdentify.py $CTR.csv $DIFF ${ATOMS}.csv

# Search-based functional atom grouping
SERVICE_CANDIDATES=${OUTPUT}/${PROJECT}_service_candidates
python optimizeAtomGrouping.py ${ATOMS}.csv ${CLASS_DEPS}.csv ${CONCERN_DEPS}.csv ${SERVICE_CANDIDATES}.csv
