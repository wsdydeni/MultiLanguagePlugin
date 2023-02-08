package wsdydeni.plugin.multi_language

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.SourceTask

class MultiLanguagePlugin : Plugin<Project> {
  override fun apply(project: Project) {
    project.extensions.create("multiLanguage",MultiLanguagePluginExtension::class.java)
    project.afterEvaluate {
      val languagesExtensions = project.extensions.findByType(MultiLanguagePluginExtension::class.java)
      languagesExtensions?.variantsLanguageList?.forEach { (variant, languageList) ->
        println("variant $variant use $languageList")
      }
    }
    // TODO 读取当前的BuildType 比较list中是否有该BuildType 目前只拿数组第一个语言类型 拷贝对应的values-xxx下的资源到values下
  }
}