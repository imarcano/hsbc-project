
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment: Fragment() {

    private lateinit var mBaseActivity: BaseActivity

    abstract fun getLayoutView(): Int

    abstract fun onViewReady(inflater: LayoutInflater, container : ViewGroup?, savedInstanceState: Bundle?, view: View)

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mBaseActivity =  getContext() as BaseActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view: View = inflater!!.inflate(getLayoutView(),container,false)
        onViewReady(inflater, container, savedInstanceState, view)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mBaseActivity =  context as BaseActivity
    }

    protected fun showProgressDialog(resMessage: Int){
        mBaseActivity.showProgressBar()
    }

    protected fun pushFragment(fragment: Fragment, vararg animations: Int){
        mBaseActivity.pushFragment(fragment, *animations)
    }


}