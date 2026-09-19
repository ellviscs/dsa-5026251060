package CampusPrintingService;

public class MonoPrint extends PrintJob {
    public MonoPrint(String id, int pages) {
        super(id, pages);
    }

    @Override
    public int calculateCharge() {
        int page = getPages();
        return 500 * page;
    }

    @Override
    public String label() {
        return "Mono";
    }
}
