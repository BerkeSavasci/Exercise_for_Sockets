/**
 * @author berkesavasci
 * 29.06.23
 * project: SocketUebung
 */
public class GETINT_PDUimpl implements GETINT_PDU {
    private final int i;
    public GETINT_PDUimpl(int i){
        this.i = i;
    }
    @Override
    public int getInt() {
        return i;
    }
}
