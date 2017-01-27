package com.martin.ads.omoshiroilib.glessential.program;

import android.content.Context;
import android.opengl.GLES20;

import com.martin.ads.omoshiroilib.R;
import com.martin.ads.omoshiroilib.util.ShaderUtils;


/**
 * Created by Ads on 2016/11/8.
 * Translate YUV420SP(NV21) to RGBA
 * it may also work with YUV420P(YV12)
 * with STM/OES
 */
public class GLOESProgram extends GLAbsProgram{

    private int muSTMatrixHandle;
    private int uTextureSamplerHandle;

    public GLOESProgram(Context context){
        super(context, R.raw.vertex_shader_oes,R.raw.fragment_shader_oes);
    }

    @Override
    public void create(){
        super.create();
        muSTMatrixHandle = GLES20.glGetUniformLocation(getProgramId(), "uSTMatrix");
        ShaderUtils.checkGlError("glGetUniformLocation uSTMatrix");
        if (muSTMatrixHandle == -1) {
            throw new RuntimeException("Could not get attrib location for uSTMatrix");
        }

        uTextureSamplerHandle= GLES20.glGetUniformLocation(getProgramId(),"sTexture");
        ShaderUtils.checkGlError("glGetUniformLocation uniform samplerExternalOES sTexture");
    }

    public int getMuSTMatrixHandle() {
        return muSTMatrixHandle;
    }

    public int getUTextureSamplerHandle() { return uTextureSamplerHandle; }
}