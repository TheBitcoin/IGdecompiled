package com.mbridge.msdk.e;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;

public final class a {
    public static int a(int i4, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (str.startsWith("errorCode: ") && str.length() > 16) {
                    return Integer.parseInt(str.substring(11, 15));
                }
                if (str.equals("do not have sorceList")) {
                    return i4 + 601;
                }
                if (str.equals("Network error,UnknownHostException")) {
                    return i4 + TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE;
                }
                if (str.equals("v3 is timeout")) {
                    return i4 + TypedValues.MotionType.TYPE_EASING;
                }
                if (!str.equals("Current unit is loading!")) {
                    if (!str.equals("current unit is loading")) {
                        if (str.equals("Network error,I/O exception response null")) {
                            return i4 + TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO;
                        }
                        if (str.equals("Network error,ConnectException")) {
                            return i4 + TypedValues.MotionType.TYPE_ANIMATE_CIRCLEANGLE_TO;
                        }
                        if (str.equals("Network error,socket timeout exception")) {
                            return i4 + TypedValues.MotionType.TYPE_PATHMOTION_ARC;
                        }
                        if (str.equals("Network error,disconnected network exception")) {
                            return i4 + TypedValues.MotionType.TYPE_DRAW_PATH;
                        }
                        if (str.equals("Network error,timeout exception")) {
                            return i4 + TypedValues.MotionType.TYPE_POLAR_RELATIVETO;
                        }
                        if (str.startsWith("Network error,please check state code")) {
                            return i4 + TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS;
                        }
                        if (str.equals("Network error,I/O exception contents null")) {
                            return i4 + TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_TYPE;
                        }
                        if (str.equals("Network unknown error")) {
                            return i4 + TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_ID;
                        }
                        if (str.equals("Network error,I/O exception")) {
                            return i4 + 613;
                        }
                        if (str.equals("web env is not support")) {
                            return i4 + 614;
                        }
                        if (str.equals("Network error,unknown")) {
                            return i4 + 615;
                        }
                        if (str.equals("Network error，sslp exception")) {
                            return i4 + 616;
                        }
                        if (str.startsWith("Cast exception, return data")) {
                            return i4 + 617;
                        }
                        if (str.equals("REQUEST_TIMEOUT")) {
                            return i4 + TypedValues.TransitionType.TYPE_FROM;
                        }
                        if (str.startsWith("The server returns an exception")) {
                            return i4 + TypedValues.TransitionType.TYPE_TO;
                        }
                        if (!str.equals("APP ALREADY INSTALLED")) {
                            if (!str.equals("Need show campaign list is NULL!")) {
                                if (str.startsWith("load no ad")) {
                                    return i4 + TypedValues.TransitionType.TYPE_AUTO_TRANSITION;
                                }
                                if (str.equals("EXCEPTION_UNIT_NOT_FOUND_IN_APP")) {
                                    return i4 + TypedValues.TransitionType.TYPE_INTERPOLATOR;
                                }
                                if (str.equals("EXCEPTION_UNIT_BIDDING_TYPE_ERROR")) {
                                    return i4 + TypedValues.TransitionType.TYPE_STAGGERED;
                                }
                                if (str.equals("No video campaign")) {
                                    return i4 + TypedValues.TransitionType.TYPE_TRANSITION_FLAGS;
                                }
                                if (str.equals("EXCEPTION_RETURN_EMPTY")) {
                                    return i4 + 708;
                                }
                                if (str.equals("EXCEPTION_APP_PLATFORM_ERROR")) {
                                    return i4 + 709;
                                }
                                if (str.equals("EXCEPTION_SERVICE_REQUEST_OS_VERSION_REQUIRED")) {
                                    return i4 + 710;
                                }
                                if (str.equals("banner res load failed")) {
                                    return i4 + 801;
                                }
                                if (str.equals("resource load timeout is tpl: false")) {
                                    return i4 + 802;
                                }
                                if (str.startsWith("resource download failed")) {
                                    return i4 + 803;
                                }
                                if (str.equals("temp preload success but isReady false")) {
                                    return i4 + 804;
                                }
                                if (str.equals("temp resource download failed")) {
                                    return i4 + 805;
                                }
                                if (str.equals("tpl temp resource download failed")) {
                                    return i4 + 806;
                                }
                                if (str.equals("resource load timeout is tpl: true")) {
                                    return i4 + 807;
                                }
                                if (!str.startsWith("https://")) {
                                    if (!str.startsWith("http://")) {
                                        if (str.equals("mraid resource write fail")) {
                                            return i4 + 809;
                                        }
                                        if (str.startsWith("data save failed:")) {
                                            return i4 + 810;
                                        }
                                        if (str.equals("resource load timeout")) {
                                            return i4 + 811;
                                        }
                                        if (str.startsWith("tpl temp preload failed")) {
                                            return i4 + 812;
                                        }
                                    }
                                }
                                return i4 + 808;
                            }
                        }
                        return i4 + 703;
                    }
                }
                return i4 + TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR;
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        return i4;
    }
}
