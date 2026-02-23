import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final InvoiceStore store;
    private final InvoiceFormatter formatter;
    private int invoiceSeq = 1000;

    public CafeteriaSystem(InvoiceStore store, InvoiceFormatter formatter) {
        this.store = store;
        this.formatter = formatter;
    }

    public void addToMenu(MenuItem i) { menu.put(i.id, i); }

    public void checkout(String customerType, List<OrderLine> lines) {
        String invId = "INV-" + (++invoiceSeq);

        double subtotal = 0.0;
        for (OrderLine l : lines) {
            subtotal += menu.get(l.itemId).price * l.qty;
        }

        TaxRule taxRule = TaxRules.forCustomerType(customerType);
        double taxPct = taxRule.taxPercent();
        double tax = subtotal * (taxPct / 100.0);

        DiscountRule discountRule = DiscountRules.forCustomerType(customerType);
        double discount = discountRule.discountAmount(subtotal, lines.size());

        double total = subtotal + tax - discount;

        String printable = formatter.format(invId, lines, menu, subtotal, taxPct, tax, discount, total);
        System.out.print(printable);

        store.save(invId, printable);
        System.out.println("Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")");
    }
}
