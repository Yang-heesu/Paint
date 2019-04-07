import java.awt.Color;
import java.io.Serializable;

class DrawInfo implements Serializable{

	/**

	 * Serializable : 객체를 외부장치로 보낼 수 있게 직렬화 해준다는 표시를 해주는 인터페이스

         * 직렬화는 데이터를 byte 단위로 직렬 정렬하여 일괄적으로 처리하기 좋게 만드는 것을 말한다.

	 * 객체를 외부장치에 저장하거나 네트워크 전송시 반드시 직렬화가 필요하다.

	 * 이 인터페이스가 구현된 객체의 저장이나 복원은 ObjectStream이 알아서 처리함.

	 * 

	 * 스트림(Stream)은 바이트들이 순서대로 입출력되는 논리적인 장치이다.

	 * 장치 간 데이터를 보낼 때 전달 수단으로 사용된다.

	 */

	private int x,y,x1,y1;

	private int type;

	private Color color;

	private boolean fill;

	

	public DrawInfo(int x, int y, int x1, int y1, int type, Color color, boolean fill) {

		

		this.x = x;

		this.y = y;

		this.x1 = x1;

		this.y1 = y1;

		this.type = type;

		this.color = color;

		this.fill = fill;

	}





	public int getX() {

		return x;

	}



	public void setX(int x) {

		this.x = x;

	}



	public int getY() {

		return y;

	}



	public void setY(int y) {

		this.y = y;

	}



	public int getX1() {

		return x1;

	}



	public void setX1(int x1) {

		this.x1 = x1;

	}



	public int getY1() {

		return y1;

	}



	public void setY1(int y1) {

		this.y1 = y1;

	}



	public int getType() {

		return type;

	}



	public void setType(int type) {

		this.type = type;

	}



	public Color getColor() {

		return color;

	}



	public void setColor(Color color) {

		this.color = color;

	}



	public boolean isFill() {

		return fill;

	}



	public void setFill(boolean fill) {

		this.fill = fill;

	}

}

