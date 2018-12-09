package entity;

public class Client {
	private String name;
	private String nip;
	private String adress;
	
	public Client(String name, String nip, String address) {
		this.name = name;
		this.nip = nip;
		this.adress = address;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getNip() {
		return nip;
	}
	public void setNip(String nip) {
		this.nip = nip;
	}

	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "Client [name=" + name + ", nip=" + nip + ", adress=" + adress + "]";
	}

}
