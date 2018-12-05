package entity;

public class Client {
	private String name;
	private String nip;
	
	public Client(String name, String nip) {
		this.name = name;
		this.nip = nip;
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

	@Override
	public String toString() {
		return "Client [name=" + name + ", nip=" + nip + "]";
	}

}
