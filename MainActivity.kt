package com.assetflux.nativeviewer

import android.app.Activity
import android.os.Bundle
import android.opengl.GLSurfaceView

class MainActivity : Activity() {

    private lateinit var glView: GLSurfaceView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        glView = GLSurfaceView(this)

        glView.setEGLContextClientVersion(2)

        glView.setRenderer(object : GLSurfaceView.Renderer {

            override fun onSurfaceCreated(
                gl: javax.microedition.khronos.opengles.GL10?,
                config: javax.microedition.khronos.egl.EGLConfig?
            ) {
                gl?.glClearColor(0.05f, 0.05f, 0.05f, 1.0f)
            }

            override fun onSurfaceChanged(
                gl: javax.microedition.khronos.opengles.GL10?,
                width: Int,
                height: Int
            ) {
                gl?.glViewport(0, 0, width, height)
            }

            override fun onDrawFrame(
                gl: javax.microedition.khronos.opengles.GL10?
            ) {
                gl?.glClear(
                    javax.microedition.khronos.opengles.GL10.GL_COLOR_BUFFER_BIT
                )
            }
        })

        setContentView(glView)
    }

    override fun onResume() {
        super.onResume()
        glView.onResume()
    }

    override fun onPause() {
        glView.onPause()
        super.onPause()
    }
}