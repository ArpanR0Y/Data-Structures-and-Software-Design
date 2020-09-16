public class Main {
	
	public static void main(String[] args) {
		
		DataTier dt = new DataTier(args[0]);
		LogicTier lt = new LogicTier(dt);
		PresentationTier pt = new PresentationTier(lt);
		pt.start();
		
	}

}
