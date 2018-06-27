package com.guhungry.earthquake.quakelist

import com.androidnetworking.common.ANRequest
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.guhungry.earthquake.data.QuakeRepository
import com.guhungry.earthquake.models.QuakeSettingModel
import com.guhungry.earthquake.utils.QueryUtils
import org.json.JSONObject

class QuakeListInteractor : QuakeListProtocol.Interactor {
    override var presenter: QuakeListProtocol.InteractorOutput? = null
    private var task: ANRequest<out ANRequest<*>>? = null

    override fun requestQuakes() {
        task = QuakeRepository.getQuakes(QuakeRepository.url(setting()))?.apply {
            getAsJSONObject(listener)
        }
    }

    override fun destroy() {
        if (task != null) {
            task?.cancel(true)
            task = null
        }
        presenter = null
    }

    private val listener = object : JSONObjectRequestListener {
        override fun onResponse(response: JSONObject) {
            presenter?.onQuakesSuccess(QueryUtils.extractQuakes(response))
        }

        override fun onError(error: ANError) {
            presenter?.onQuakesFailed()
        }
    }

    private fun setting(): QuakeSettingModel = QueryUtils.settingsFromPreferences()
}