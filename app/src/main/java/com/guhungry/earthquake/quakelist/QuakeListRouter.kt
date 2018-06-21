package com.guhungry.earthquake.quakelist

import android.content.Context
import android.content.Intent
import android.net.Uri

class QuakeListRouter {
    companion object : QuakeListProtocol.Router {
        override fun createQuakeDetail(context: Context, url: String) {
            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }

        override fun presenter(view: QuakeListProtocol.View): QuakeListProtocol.Presenter {
            val presenter = QuakeListPresenter()
            val interactor: QuakeListProtocol.Interactor = QuakeListInteractor()
            val router: QuakeListProtocol.Router = this

            presenter.view = view
            presenter.interactor = interactor
            presenter.router = router
            interactor.presenter = presenter
            return presenter
        }
    }
}