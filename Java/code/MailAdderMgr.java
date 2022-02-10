import java.util.HashMap;

class MailAddrMgr {
    private HashMap<String, String> map;

    public MailAddrMgr() {
        map = new HashMap<String, String>();
        map.put("Kobayashi", "tkobaya@c.titech.ac.jp");
        map.put("Moriguchi", "chiguri@c.titech.ac.jp");
    }
    
    public String getMailAddr(String name) {
        return this.map.get(name);
    }

    public static void main(String[] args) {
        String name = "Kobayashi";
        String addr = new MailAddrMgr().getMailAddr(name);
        System.out.println(addr);
    }
}