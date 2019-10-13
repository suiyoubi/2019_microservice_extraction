
# Representative execution trace extraction
set -x
PROJECT_NAME=jpetstore
PROJECT_PACKAGE=org.mybatis.jpetstore
OUTPUT=./${PROJECT_NAME}_outputs
EXECUTION_TRACES=./execution_data/${PROJECT_NAME}
# Workflow and testcase name files are already generated for jpetstore
WORKFLOW=${EXECUTION_TRACES}/${PROJECT_NAME}_workflow
TESTCASE_NAME=${EXECUTION_TRACES}/${PROJECT_NAME}_testcase_name
mkdir $OUTPUT

# Produce the representative execution trace set
# python reduceWorkflow.py ${WORKFLOW}.csv ${WORKFLOW}_reduced.csv ${TESTCASE_NAME}.csv   

# Generate a file that holds all the class dependencies, based on the extracted execution traces
CLASS_DEPS=${OUTPUT}/${PROJECT_NAME}_class_dependencies
python classCallDep.py ${WORKFLOW}_reduced.csv ${CLASS_DEPS}.csv

# Generate classfilename file and featureVector file
TESTCASE=${OUTPUT}/${PROJECT_NAME}_testcase
python genTestCaseFv.py ${WORKFLOW}_reduced.csv ${TESTCASE_NAME}.csv null null ${TESTCASE}_class.csv ${TESTCASE}_fv.csv   

# Generate a file that holds all the concern dependencies, based on the extracted execution traces
CONCERN_DEPS=${OUTPUT}/${PROJECT_NAME}_concern_dependencies
python classConcernDep.py ${TESTCASE}_class.csv ${CONCERN_DEPS}.csv

# Generate a set of classes involved in each trace tri
CTR=${OUTPUT}/${PROJECT_NAME}_ctr
python groupClassByTrace.py ${TESTCASE}_fv.csv ${TESTCASE}_class.csv ${CTR}.csv  

# Initialize functional atoms s.t. Fa = { Ci } 
DIFF=3
ATOMS=${OUTPUT}/${PROJECT_NAME}_atoms
python functionLogicIdentify.py $CTR.csv $DIFF ${ATOMS}.csv

# Search-based functional atom grouping
SERVICE_CANDIDATES=${OUTPUT}/${PROJECT_NAME}_service_candidates
python optimizeAtomGrouping.py ${ATOMS}.csv ${CLASS_DEPS}.csv ${CONCERN_DEPS}.csv ${SERVICE_CANDIDATES}.csv > ${OUTPUT}/sortingAlgo.log

