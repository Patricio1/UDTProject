package uta.gad.udt.models.entity;
import java.io.Serializable;
import javax.persistence.*;


@Entity
@NamedNativeQueries({
	@NamedNativeQuery(
	name = "listarLinksInteres",
	query = "EXEC sp_SelectLinksInteres",
	resultClass = Link1.class
	)
})
@Table(name = "Link",schema="portal")
public class Link1 implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private byte idLink;
	private String nombre;
	private String url;

	public Link1() {
	}

	public Link1(byte idLink, String nombre, String url) {
		this.idLink = idLink;
		this.nombre = nombre;
		this.url = url;
	}

	public byte getIdLink() {
		return this.idLink;
	}

	public void setIdLink(byte idLink) {
		this.idLink = idLink;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}