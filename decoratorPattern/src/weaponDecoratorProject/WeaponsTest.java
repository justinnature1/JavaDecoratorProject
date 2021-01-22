package weaponDecoratorProject;

public class WeaponsTest {

	public static void main (String[] args) throws InterruptedException {
		//Creates and displays info for an unwrapped Dagger Weapon
		Weapon dagger = new Dagger();
		dagger.getDescription();
		System.out.println(dagger.getDescription());
		System.out.println(dagger.weaponStats());
		
		//Creates and displays info for a wrapped dagger.
		Weapon decoratedDagger = new Dagger();
		decoratedDagger = new DamageDecorator(decoratedDagger);
		decoratedDagger = new AttackSpeedDecorator(decoratedDagger);
		System.out.println(decoratedDagger.getDescription());
		System.out.println(decoratedDagger.weaponStats());

		//Creates and displays info for a wrapped sword.
		Weapon decoratedSword = new Sword();
		decoratedSword = new CritcalHitDecorator(decoratedSword);
		System.out.println(decoratedSword.getDescription());
		System.out.println(decoratedSword.weaponStats());

		//Creates and displays info for a wrapped axe.
		Weapon decoratedAxe = new Axe();
		decoratedAxe = new CritcalHitDecorator(decoratedAxe);
		decoratedAxe = new AttackSpeedDecorator(decoratedAxe);
		decoratedAxe = new DamageDecorator(decoratedAxe);
		System.out.println(decoratedAxe.getDescription());
		System.out.println(decoratedAxe.weaponStats());	
		
		//Simulates a player using a the decoratedAxe weapon to attack an opponent.
		System.out.println("Attacking with Equipped Weapon: " + decoratedAxe.getDescription());
		for (int i = 0; i < 10; i++) {
			System.out.println("Damage: " + decoratedAxe.attack());
			Thread.sleep(500); //Pauses code execution for .5 seconds (500 ms)
		}
		
		System.out.println();
		
		//Simulates a player using a the dagger weapon to attack an opponent.
		System.out.println("Attacking with Equipped Weapon: " + dagger.getDescription());
		for (int i = 0; i < 10; i++) {
			System.out.println("Damage: " + dagger.attack());
			Thread.sleep(500); //Pauses code execution for .5 seconds (500 ms)
		}

	}
}
