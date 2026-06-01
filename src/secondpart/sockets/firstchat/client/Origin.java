package secondpart.sockets.firstchat.client;

public class Origin {
	private String nick, message, ip;
	
	public Origin(String nick, String message, String ip) {
		this.nick = nick;
		this.message = message;
		this.ip = ip;
	}
	
	public String getNick() {return this.nick;}
	public String getMessage() {return this.message;}
	public String getIp() {return this.ip;}
	
	@Override
	public String toString() {
		return "%s: %s. -> %s"
			.formatted(nick, message, ip);
	}
}