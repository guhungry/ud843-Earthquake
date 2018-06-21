package com.guhungry.earthquake.quakelist

import com.guhungry.earthquake.models.QuakeModel

abstract class QuakeListProtocol {
    interface View {
        var presenter: Presenter?

        fun onQuakesSuccess(quakes: ArrayList<QuakeModel>)
        fun onQuakesFailed()
    }

    interface Presenter {
        var view: View?
        var interactor: Interactor?
        var router: Router?

        fun requestQuakes()
        fun destroy()
    }

    interface Interactor {
        var presenter: InteractorOutput?

        fun requestQuakes()
        fun destroy()
    }

    interface InteractorOutput {
        fun onQuakesSuccess(quakes: ArrayList<QuakeModel>)
        fun onQuakesFailed()
    }

    interface Router {
        fun presenter(view: View) : QuakeListProtocol.Presenter
    }
}