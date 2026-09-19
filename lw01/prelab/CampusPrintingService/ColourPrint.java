package CampusPrintingService;

public class ColourPrint extends PrintJob {
    public ColourPrint(String id, int pages) {
        super(id, pages);
    }

    @Override
    public int calculateCharge() {
        int page = getPages();
        if (page > 10) {
            return 10 * 1500 + (page - 10) * 1000 + 2000;
        } else {
            return page * 1500 + 2000;
        }
    }

    @Override
    public String label() {
        return "Colour";
    }
    
}
