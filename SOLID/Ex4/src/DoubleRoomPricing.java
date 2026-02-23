public class DoubleRoomPricing implements RoomPricing {
    @Override
    public boolean matches(int roomType) {
        return roomType == LegacyRoomTypes.DOUBLE;
    }

    @Override
    public Money monthlyRate() {
        return new Money(15000.0);
    }
}
