package com.ttmc.crack.hook

import com.highcapable.yukihookapi.annotation.xposed.InjectYukiHookWithXposed
import com.highcapable.yukihookapi.hook.factory.encase
import com.highcapable.yukihookapi.hook.xposed.proxy.IYukiHookXposedInit


/*
 * Main hook
 */
@InjectYukiHookWithXposed
object HookEntry : IYukiHookXposedInit {

    override fun onHook() = encase {
        loadApp(name = "com.zhiliaoapp.musically") {
            findClass("TT_J.TT_A").hook {
                injectMember {
                    method {
                        name = "M4abcdEF"
                    }
                    replaceAny { null }
                }
            }
        }
    }
}