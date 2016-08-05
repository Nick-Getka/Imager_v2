package imager.pro;

import java.awt.image.BufferedImage;

public abstract class ImgPro {
	private BufferedImage img;

	public BufferedImage getImg() {
		return img;
	}
	public void setImg(BufferedImage img) {
		this.img = img;
	}
	public ImgPro(BufferedImage img) {
		super();
		this.img = img;
	}
	public ImgPro() {
		super();
		this.img = null;
	}
	
}
