package ExExceptionPers3.model.entities;

import ExExceptionPers3.model.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation3 {

    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation3() {
    }

    //por ser (EXCEPTION) OBRIGA a colocar (throws DomainException)
    public Reservation3(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
        if (!checkOut.after(checkIn)){
            throw new DomainException("Check-out date must be after check-in date");
        }
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

    // O (THROWS DOMAINEXCEPTION) serve para avisar que esse metodo pode lançar essa exceção
    public void updateDates(Date checkIn, Date checkOut) throws DomainException {
        Date now = new Date();
        //erros possiveis
        if (checkIn.before(now) || checkOut.before(now)) {
            // (IllegalArgumentException) é utilizado quando os argumentos que sao passados a um metodo sao INVALIDOS
            throw new DomainException("Reservation dates for update must be future dates");
        }
        if (!checkOut.after(checkIn)){
            throw new DomainException("Check-out date must be after check-in date");
        }
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
