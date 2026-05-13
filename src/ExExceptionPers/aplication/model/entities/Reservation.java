package ExExceptionPers.aplication.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation() {
    }

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public long duration() {
        long diff = checkOut.getTime() - checkIn.getTime(); //pega a diff entre as datas em m/s
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); //converte o tempo que esta em m/s para dias
    }

    public void updateDates(Date checkIn, Date checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    //o "toString" ja é uma sobreposição
    @Override
    public String toString() {
        return "Romm "
                + roomNumber
                + ", check-in: "
                + sdf.format(checkIn)
                + ", check-out: "
                + sdf.format(checkOut)
                + ", duration: "
                + duration()
                + " nights";

    }
}
