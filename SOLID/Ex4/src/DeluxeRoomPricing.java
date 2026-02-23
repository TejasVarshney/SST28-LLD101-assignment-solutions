public class DeluxeRoomPricing implements RoomPricing {
    @Override
    public boolean matches(int roomType) {
        return roomType == LegacyRoomTypes.DELUXE;
    }

    @Override
    public Money monthlyRate() {
        return new Money(16000.0);
    }
}
