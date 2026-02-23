public interface RoomPricing {
    boolean matches(int roomType);
    Money monthlyRate();
}
