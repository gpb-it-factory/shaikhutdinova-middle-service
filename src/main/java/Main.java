import base.Callback;
import controller.UserController;
import domain.api.UserApiCreator;
import domain.repository.UserRepository;
import usecases.CreateUserInteractor;

// Главный класс приложения
public class Main {
    public static void main(String[] args) {
        UserController userController = new UserController(new CreateUserInteractor(new UserRepository(new UserApiCreator(true).create())) {
            {

                createUser("Petr", "petr@petr.gmail", new Callback() {
                    @Override
                    public void onSuccess() {
                        // Успешное создание пользователя
                    }

                    @Override
                    public void onError(Throwable e) {
                        // Обработка ошибки
                    }
                });
            }

        });
    }
}
