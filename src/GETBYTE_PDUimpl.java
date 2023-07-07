/**
 * @author berkesavasci
 * 29.06.23
 * project: SocketUebung
 */
public class GETBYTE_PDUimpl implements GETBYTE_PDU{
    private final byte x;

    public GETBYTE_PDUimpl(byte x) {
        this.x = x;
    }

    @Override
    public byte getByte() {
        return x;
    }
}
