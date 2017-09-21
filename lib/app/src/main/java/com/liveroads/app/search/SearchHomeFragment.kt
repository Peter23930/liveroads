package com.liveroads.app.search

/**
 * Created by android on 8/25/17.
 */

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.liveroads.app.R
import com.liveroads.common.log.obtainLogger
import com.liveroads.ui.search.SearchResultEntryView
import com.liveroads.util.findViewByIdOrThrow
import com.liveroads.util.log.*

class SearchHomeFragment: Fragment() {
    val logger = obtainLogger()

    var homeMenuSection : LinearLayout? = null
    var workMenuSection : LinearLayout? = null
    var homeSection : LinearLayout? = null
    var workSection : LinearLayout? = null
    var homeAddress : TextView? = null
    var workAddress : TextView? = null
    var homeDistance : TextView? = null
    var workDistance : TextView? = null

    var recentShow : RelativeLayout? = null
    var recentSearch : SearchResultEntryView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        logger.onCreate(savedInstanceState)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        logger.onCreateView(inflater, container, savedInstanceState)

        val view : View = inflater.inflate(R.layout.lr_search_home_fragment, container, false)
        homeMenuSection = view.findViewByIdOrThrow<LinearLayout>(R.id.home_address_menu)
        workMenuSection = view.findViewByIdOrThrow(R.id.work_address_menu)
        homeSection = view.findViewByIdOrThrow(R.id.set_home_address)
        workSection = view.findViewByIdOrThrow(R.id.set_work_address)
        homeAddress = view.findViewByIdOrThrow(R.id.home_address)
        workAddress = view.findViewByIdOrThrow(R.id.work_address)
        homeDistance = view.findViewByIdOrThrow(R.id.home_distance)
        workDistance = view.findViewByIdOrThrow(R.id.work_distance)

        recentShow = view.findViewByIdOrThrow(R.id.lr_recent)
        recentSearch = view.findViewByIdOrThrow(R.id.lr_recentSearch)

        return view
    }

    override fun onDestroy() {
        logger.onDestroy()
        super.onDestroy()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        logger.onActivityCreated(savedInstanceState)
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        logger.onViewStateRestored(savedInstanceState)
        super.onViewStateRestored(savedInstanceState)
    }

    override fun onStart() {
        logger.onStart()
        super.onStart()
    }

    override fun onStop() {
        logger.onStop()
        super.onStop()
    }

}