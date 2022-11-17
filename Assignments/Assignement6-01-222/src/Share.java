class Bluetooth {
	public  void shareVia(String bluetooth) {
		System.out.println("share via blutooth:");
	}
}
class Gmail{
	public void shareVia(String gmail) {
		System.out.println("share via Gmail:");
	}
}
class WhatsappGroup{
	public void shareVia(String whatsappgrup) {
		System.out.println("share via WhatsappGroup:");
}
}
class WhatsappUser{
	public void shareVia(String whatsappUser) {
		System.out.println("share via WhatsappUser:");
	}
}
class WhatsappUserandWhatsappGroup{
	public void shareVia(String whatsappUser,String whatsappGroup){
		System.out.println("share via WhatsappUser:and whatsappgroup:");
	}
}
public class Share{
	public static void main(String[] args) {
		//Share s=new Share();
		Bluetooth b=new Bluetooth();
		b.shareVia("enfec");
		Gmail g=new Gmail();
		g.shareVia("Hyd");
		WhatsappGroup wg=new WhatsappGroup();
		wg.shareVia("solutions");
		WhatsappUser s1=new WhatsappUser();
		s1.shareVia("subbu");
		WhatsappUserandWhatsappGroup s=new WhatsappUserandWhatsappGroup();
		s.shareVia("java","program");

	}
}
