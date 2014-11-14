import com.google.inject.AbstractModule;
import services.Service;
import services.ServiceImpl;

public class GuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Service.class).to(ServiceImpl.class);
    }
}
