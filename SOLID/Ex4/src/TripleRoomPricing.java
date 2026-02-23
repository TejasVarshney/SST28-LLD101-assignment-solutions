public class TripleRoomPricing implements RoomPricing {
    @Override
    public boolean matches(int roomType) {
        return roomType == LegacyRoomTypes.TRIPLE;
    }

    @Override
    public Money monthlyRate() {
        return new Money(12000.0);
    }
}
