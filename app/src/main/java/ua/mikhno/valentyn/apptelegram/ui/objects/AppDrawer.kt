package ua.mikhno.valentyn.apptelegram.ui.objects

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem
import ua.mikhno.valentyn.apptelegram.R
import ua.mikhno.valentyn.apptelegram.ui.fragments.SettingsFragment

class AppDrawer(val mainActivity: AppCompatActivity, val toolbar: Toolbar) {
    private lateinit var mDrawer: Drawer
    private lateinit var mHeader: AccountHeader

    fun create() {
        createHeader()
        createDrawer()
    }

    private fun createDrawer() {
        mDrawer = DrawerBuilder()
            .withActivity(mainActivity)
            .withToolbar(toolbar)
            .withActionBarDrawerToggle(true)
            .withSelectedItem(-1)
            .withAccountHeader(mHeader)
            .addDrawerItems(
                primaryDrawerItem(100, "Создать группу", R.drawable.ic_menu_contacts),
                primaryDrawerItem(101, "Создать секретный чат", R.drawable.ic_menu_secret_chat),
                primaryDrawerItem(102, "Создать канал", R.drawable.ic_menu_create_channel),
                primaryDrawerItem(103, "Контакты", R.drawable.ic_menu_contacts),
                primaryDrawerItem(104, "Звонки", R.drawable.ic_menu_phone),
                primaryDrawerItem(105, "Избранное", R.drawable.ic_menu_favorites),
                primaryDrawerItem(106, "Настройки", R.drawable.ic_menu_settings),
                DividerDrawerItem(),
                primaryDrawerItem(107, "Пригласить друзей", R.drawable.ic_menu_invate),
                primaryDrawerItem(108, "Вопросы о Telegram", R.drawable.ic_menu_help)
            )
            .withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener {
                override fun onItemClick(
                    view: View?,
                    position: Int,
                    drawerItem: IDrawerItem<*>
                ): Boolean {
                    when (position) {
                        7 -> mainActivity.supportFragmentManager.beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.dataContainer, SettingsFragment()).commit()
                    }
                    return false
                }
            })
            .build()
    }

    private fun primaryDrawerItem(identifier: Long, name: String, idIcon: Int) =
        PrimaryDrawerItem()
            .withIdentifier(identifier)
            .withIconTintingEnabled(true)
            .withName(name)
            .withSelectable(false)
            .withIcon(idIcon)

    private fun createHeader() {
        mHeader = AccountHeaderBuilder()
            .withActivity(mainActivity)
            .withHeaderBackground(R.drawable.header)
            .addProfiles(
                ProfileDrawerItem()
                    .withName("Valentyn Mikhno")
                    .withEmail("+380500308392")
            ).build()
    }

}