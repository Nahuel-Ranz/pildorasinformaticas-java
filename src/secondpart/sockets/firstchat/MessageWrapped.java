package secondpart.sockets.firstchat;
import java.io.Serializable;

public class MessageWrapped implements Serializable {
	private static final long serialVersionUID = 23234L;
	private String nick, message, ip;
	
	public MessageWrapped(String nick, String message, String ip) {
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