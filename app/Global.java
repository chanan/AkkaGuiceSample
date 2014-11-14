import akkaGuice.AkkaGuice;
import akkaGuice.AkkaGuiceModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import play.Application;
import play.GlobalSettings;

public class Global extends GlobalSettings {
    private Injector injector;

    @Override
    public <A> A getControllerInstance(Class<A> aClass) throws Exception {
        return injector.getInstance(aClass);
    }

    @Override
    public void onStart(Application application) {
        injector = Guice.createInjector(new AkkaGuiceModule(), new GuiceModule());
        AkkaGuice.InitializeInjector(injector);
    }
}