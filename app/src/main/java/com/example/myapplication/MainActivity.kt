package com.example.myapplication

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.example.myapplication.bean.ProductEntity
import com.example.myapplication.bean.UserBean
import com.example.myapplication.contract.LoginContract
import com.example.myapplication.contract.ProductContract
import com.example.myapplication.presenter.LoginPresenter
import com.example.myapplication.presenter.ProductPresenter
import com.jcodecraeer.xrecyclerview.XRecyclerView
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : RxAppCompatActivity(), View.OnClickListener, LoginContract.ILoginView,
    ProductContract.IProductView, XRecyclerView.LoadingListener {

    var page: Int = 1

    lateinit var loginPresenter: LoginPresenter
    lateinit var productPresenter: ProductPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()

    }

    private fun initData() {
        loginPresenter = LoginPresenter()
        productPresenter = ProductPresenter()

    }

    //初始化view
    private fun initView() {

        login.setOnClickListener(this)
        getMovies.setOnClickListener(this)

        xrv.layoutManager = LinearLayoutManager(this)
        xrv.setLoadingListener(this)

        xrv.setLoadingMoreEnabled(true)



    }

    //登录测试

    fun login() {
        var params = HashMap<String, String>()
        params.put("phone", "15097663019")
        params.put("pwd", "123456")

        loginPresenter.attach(this)
        loginPresenter.login(params, this)

    }

    // 获取影片列表

    private fun getMovies() {
        var params = HashMap<String, String>()
        params.put("keyword", "电脑")
        params.put("page", page.toString())
        params.put("count", "1")
        productPresenter.attach(this)
        productPresenter.getProducts(params, this)

    }

    override fun success(userBean: UserBean) {
        Toast.makeText(this, userBean.result.phone, Toast.LENGTH_SHORT).show()

    }

    override fun failure(string: String) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show()

    }

    // 商品列表

    override fun success(productEntity: ProductEntity) {

    }

    override fun onDestroy() {
        super.onDestroy()
        loginPresenter.detach()
        productPresenter.datach()
    }


    // 点击事件

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.login -> login()
            R.id.getMovies -> getMovies()
        }
    }


    // 分页

    override fun onLoadMore() {
        page++
        getMovies()

    }

    // 下拉刷新

    override fun onRefresh() {

        page = 1
        getMovies()

    }

}
