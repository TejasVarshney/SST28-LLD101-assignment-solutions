import java.util.*;

public class HostelFeeCalculator {
    private final FakeBookingRepo repo;
    private final List<RoomPricing> roomPricings;
    private final List<AddOnPricing> addOnPricings;

    public HostelFeeCalculator(FakeBookingRepo repo) {
        this.repo = repo;
        this.roomPricings = List.of(
            new SingleRoomPricing(),
            new DoubleRoomPricing(),
            new TripleRoomPricing(),
            new DeluxeRoomPricing()
        );
        this.addOnPricings = List.of(
            new MessPricing(),
            new LaundryPricing(),
            new GymPricing()
        );
    }

    public void process(BookingRequest req) {
        Money monthly = calculateMonthly(req);
        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000));
        repo.save(bookingId, req, monthly, deposit);
    }

    private Money calculateMonthly(BookingRequest req) {
        Money total = new Money(0.0);

        for (RoomPricing rp : roomPricings) {
            if (rp.matches(req.roomType)) {
                total = total.plus(rp.monthlyRate());
                break;
            }
        }

        for (AddOn a : req.addOns) {
            for (AddOnPricing ap : addOnPricings) {
                if (ap.matches(a)) {
                    total = total.plus(ap.price());
                    break;
                }
            }
        }

        return total;
    }
}
