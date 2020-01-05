package com.garanti.belgeleri.di;

import android.content.Context;

import com.garanti.belgeleri.App;
import com.garanti.belgeleri.domain.services.jobs.GcmJobService;
import com.garanti.belgeleri.domain.services.jobs.SchedulerJobService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    Context provideContext(App application) {
        return application.getApplicationContext();
    }

    @Singleton
    @Provides
    SchedulerJobService provideSchedulerJobService() {
        return new SchedulerJobService();
    }

    @Singleton
    @Provides
    GcmJobService provideGcmJobService() {
        return new GcmJobService();
    }
}
