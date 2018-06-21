package com.guhungry.earthquake.quakelist

class QuakeListRouter {
    companion object : QuakeListProtocol.Router {
        override fun presenter(view: QuakeListProtocol.View) : QuakeListProtocol.Presenter {
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