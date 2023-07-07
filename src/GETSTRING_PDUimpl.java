/**
 * @author berkesavasci
 * 28.06.23
 * project: SocketUebung
 */
public class GETSTRING_PDUimpl implements GETSTRING_PDU {
    private final String word;

    public GETSTRING_PDUimpl(String word) {
        this.word = word;
    }

    @Override
    public String getString() {
        return this.word;
    }
}
