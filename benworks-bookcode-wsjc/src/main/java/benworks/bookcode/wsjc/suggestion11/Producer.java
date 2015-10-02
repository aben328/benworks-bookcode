package benworks.bookcode.wsjc.suggestion11;

import benworks.bookcode.wsjc.utils.SerializationUtils;

public class Producer {

	public static void main(String[] args) {
		Person person = new Person();
		person.setName("混世魔王");
		SerializationUtils.writeObject(person);

	}
}
