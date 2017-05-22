package pokemon.CoreClasses;

public class CardTrainer extends Card {
	public static final int TRAINER_STADIUM = 0;
	public static final int TRAINER_SUPPORT = 1;
	public static final int TRAINER_ITEM 	= 2;

	public int trainer_type;
	public int heal_amount;
	String name="";
	
	public CardTrainer() {
	super(2);
	}
	
	public void initTrainer(String name,int trainer_type,int heal_amount)
	{
		this.trainer_type=trainer_type;
		this.heal_amount=heal_amount;
		this.name=name;
	}
	
}
