package com.guhungry.earthquake.quakelist

import android.content.Context
import com.guhungry.earthquake.models.QuakeModel

class QuakeListPresenter : QuakeListProtocol.Presenter, QuakeListProtocol.InteractorOutput {
    override var view: QuakeListProtocol.View? = null
    override var interactor: QuakeListProtocol.Interactor? = null
    override var router: QuakeListProtocol.Router? = null

    // ///////////////////
    // Presenter Interface
    // ///////////////////
    override fun requestQuakes() {
        interactor?.requestQuakes()
        view?.showProgress()
    }

    override fun showQuakeDetail(context: Context, url: String) {
        router?.createQuakeDetail(context, url)
    }

    override fun destroy() {
        view = null
        interactor = null
        router = null
    }

    // Interactor Output Interface
    override fun onQuakesSuccess(quakes: ArrayList<QuakeModel>) {
        view?.hideProgress()
        view?.onQuakesSuccess(quakes)
    }

    override fun onQuakesFailed() {
        view?.hideProgress()
        view?.onQuakesFailed()
    }
}