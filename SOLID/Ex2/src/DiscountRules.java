public class DiscountRules {
    public static DiscountRule forCustomerType(String customerType) {
        if ("student".equalsIgnoreCase(customerType))
            return (subtotal, lines) -> subtotal >= 180.0 ? 10.0 : 0.0;
        if ("staff".equalsIgnoreCase(customerType))
            return (subtotal, lines) -> lines >= 3 ? 15.0 : 5.0;
        return (subtotal, lines) -> 0.0;
    }
}
