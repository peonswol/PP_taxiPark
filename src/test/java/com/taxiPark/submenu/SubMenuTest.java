package com.taxiPark.submenu;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

class SubMenuTest extends TestCase {

    SubMenu subMenu = new SubMenu();

    /*@Test
    void testExecute() {
        Scanner scanner = new Scanner(System.in);
        subMenu.menu.set(0, Mockito.mock(MenuExit.class));

        //todo
        doNothing().when(subMenu.menu.get(0)).execute(scanner, null);

        subMenu.execute(0, scanner, null);

        verify(subMenu.menu.get(0), timeout(1)).execute(new Scanner(System.in), null);
    }*/

    /*@Test
    void testOpenSubMenu() {
        SubMenu subMenuMock = Mockito.mock(SubMenu.class);
        subMenuMock.callEnterCommandMenu = Mockito.mock(CallEnterCommandMenu.class);
        Scanner scanner = new Scanner(System.in);

        when(subMenu.callEnterCommandMenu.enterCommandCheckException(scanner, subMenu.sizeOfCommands())).thenReturn(0);
        doNothing().when(subMenuMock).callIntoMenu();
        doNothing().when(subMenuMock).execute(0, scanner, null);

        subMenu.openSubMenu(subMenuMock, scanner, null);

        verify(subMenuMock).execute(0, scanner, null);
    }*/
    @Test
    public void testSizeOfCommands() {
        assertEquals(6, subMenu.sizeOfCommands());
    }

    @Test
    public void testCallIntoMenu() {
    }

    @Test
    public void testShowMenu() {
    }
}