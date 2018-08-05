package com.tahamalas.notetakingapp.di.component

import com.tahamalas.notetakingapp.base.IBaseView
import com.tahamalas.notetakingapp.di.module.ApplicationModule
import com.tahamalas.notetakingapp.domainlayer.add.AddPresenter
import com.tahamalas.notetakingapp.domainlayer.display.DisplayPresenter
import com.tahamalas.notetakingapp.domainlayer.edit.EditPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(ApplicationModule::class)])
interface PresenterInjector {
    /**
     * Injects required dependencies into the specified DisplayPresenter.
     * @param displayPresenter DisplayPresenter in which to inject the dependencies
     */
    fun inject(displayPresenter: DisplayPresenter)

    fun inject(addPresenter: AddPresenter)

    fun inject(editPresenter: EditPresenter)

    @Component.Builder
    interface Builder {
        fun build(): PresenterInjector

        fun applicationModule(applicationModule: ApplicationModule): Builder

        @BindsInstance
        fun baseView(baseView: IBaseView): Builder
    }

}
