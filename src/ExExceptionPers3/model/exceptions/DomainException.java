package ExExceptionPers3.model.exceptions;

//(Exception) é OBRIGADO a tratar (RunTimeException) NÃO é obrigado a tratar
public class DomainException extends Exception{
    private static final long serialVersionUID = 1L;

    // para permitir a instanciação da exceção pers. passando uma msgn para ela
    public DomainException(String message){
        super(message);
    }
}
