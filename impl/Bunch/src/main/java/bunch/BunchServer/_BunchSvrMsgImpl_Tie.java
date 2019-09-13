// Tie class generated by rmic, do not edit.
// Contents subject to change without notice.

package bunch.BunchServer;

import bunch.Callback;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.rmi.CORBA.Tie;
import javax.rmi.CORBA.Util;
import javax.rmi.PortableRemoteObject;
import org.omg.CORBA.BAD_OPERATION;
import org.omg.CORBA.ORB;
import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.ResponseHandler;
import org.omg.CORBA.portable.UnknownException;
import org.omg.CORBA_2_3.portable.ObjectImpl;


public class _BunchSvrMsgImpl_Tie extends ObjectImpl implements Tie {
    
    private BunchSvrMsgImpl target = null;
    
    private static final String[] _type_ids = {
        "RMI:bunch.BunchServer.BunchSvrMsg:0000000000000000"
    };
    
    public void setTarget(Remote target) {
        this.target = (BunchSvrMsgImpl) target;
    }
    
    public Remote getTarget() {
        return target;
    }
    
    public org.omg.CORBA.Object thisObject() {
        return this;
    }
    
    public void deactivate() {
        _orb().disconnect(this);
        _set_delegate(null);
        target = null;
    }
    
    public ORB orb() {
        return _orb();
    }
    
    public void orb(ORB orb) {
        orb.connect(this);
    }
    
    public String[] _ids() { 
        return _type_ids;
    }
    
    public OutputStream  _invoke(String method, InputStream _in, ResponseHandler reply) throws SystemException {
        try {
            org.omg.CORBA_2_3.portable.InputStream in = 
                (org.omg.CORBA_2_3.portable.InputStream) _in;
            switch (method.length()) {
                case 8: 
                    if (method.equals("doAction")) {
                        String arg0 = (String) in.read_value(String.class);
                        boolean result = target.doAction(arg0);
                        OutputStream out = reply.createReply();
                        out.write_boolean(result);
                        return out;
                    }
                case 13: 
                    if (method.equals("invokeMessage")) {
                        String arg0 = (String) in.read_value(String.class);
                        byte[] arg1 = (byte[]) in.read_value(byte[].class);
                        boolean result = target.invokeMessage(arg0, arg1);
                        OutputStream out = reply.createReply();
                        out.write_boolean(result);
                        return out;
                    }
                case 16: 
                    if (method.equals("registerCallback")) {
                        Callback arg0 = (Callback) PortableRemoteObject.narrow(in.read_Object(), Callback.class);
                        boolean result = target.registerCallback(arg0);
                        OutputStream out = reply.createReply();
                        out.write_boolean(result);
                        return out;
                    }
            }
            throw new BAD_OPERATION();
        } catch (SystemException ex) {
            throw ex;
        } catch (Throwable ex) {
            throw new UnknownException(ex);
        }
    }
}
