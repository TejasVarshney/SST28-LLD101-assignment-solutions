public class SingleRoomPricing implements RoomPricing {
    @Override
    public boolean matches(int roomType) {
        return roomType == LegacyRoomTypes.SINGLE;
    }

    @Override
    public Money monthlyRate() {
        return new Money(14000.0);
    }
}
