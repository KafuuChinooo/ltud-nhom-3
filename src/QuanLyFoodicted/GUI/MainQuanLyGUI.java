package QuanLyFoodicted.GUI;


import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class MainQuanLyGUI extends JFrame {

    public MainQuanLyGUI() {
        this.setTitle("Phần mềm quản lý cửa hàng foodicted");
        this.setSize(1280, 900);
        Image icon = Toolkit.getDefaultToolkit().getImage("image/ManagerUI/icon-app.png");
        this.setIconImage(icon);
        addControls();
        addEvents();
    }

    public void showWindow() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    JPanel pnTitle, pnMenuLeft, pnCard, pnBanHang, pnSanPham, pnNhanVien, pnKhachHang;
    PnQuanLyBanHangGUI banHangPanel;
    PnQuanLySanPhamGUI sanPhamPanel;
    PnQuanLyNhanVienGUI nhanVienPanel;
    PnQuanLyKhachHangGUI khachHangPanel;

    JLabel btnClose, btnMinimize, lblBanHang, lblSanPham, lblNhanVien, lblKhachHang;
    final Color clLeftItem = new Color(26, 26, 29);
    final Color clLeftItemHover = new Color(72, 88, 107);
    final Color clLeftItemSelected = new Color(230, 193, 16);
    ArrayList<JLabel> listMenuLeft;
    CardLayout cardMenuLeftGroup = new CardLayout();

    private void addControls() {
        int width = this.getWidth();
        int height = this.getHeight();

        Container con = getContentPane();

        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BorderLayout());

        /*
        ============================================================
                                TITLE BAR
        ============================================================
         */
        pnTitle = new JPanel(null);
        pnTitle.setPreferredSize(new Dimension(width, 46));
        pnTitle.setBackground(new Color(255, 255, 255));
        pnTitle.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));


        JLabel lblTitleText = new JLabel(new ImageIcon("image/ManagerUI/title-text.png"));
        lblTitleText.setBounds(width / 2 - 428 / 2, 3, 428, 38);
        pnTitle.add(lblTitleText);

        btnMinimize = new JLabel(new ImageIcon("image/ManagerUI/btn-minimize.png"));
        btnMinimize.setBounds(width - 85, 5, 38, 35);
        btnMinimize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnTitle.add(btnMinimize);

        btnClose = new JLabel(new ImageIcon("image/ManagerUI/btn-close.png"));
        btnClose.setBounds(width - 40, 5, 35, 35);
        btnClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnTitle.add(btnClose);

        pnMain.add(pnTitle, BorderLayout.NORTH);
        /*
        ============================================================
                                SIDE BAR MENU
        ============================================================
         */
        pnMenuLeft = new JPanel();
        pnMenuLeft.setPreferredSize(new Dimension(250, height - pnTitle.getHeight()));
        pnMenuLeft = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    ImageIcon icon = new ImageIcon("image/ManagerUI/slidebar-background.png");
                    Image image = icon.getImage();
                    g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        pnMenuLeft.setLayout(new BoxLayout(pnMenuLeft, BoxLayout.Y_AXIS));


        JLabel lblAvatar = new JLabel(new ImageIcon("image/ManagerUI/avatar.png"), JLabel.CENTER);
        lblAvatar.setPreferredSize(new Dimension(250, 210));
        pnMenuLeft.add(lblAvatar);

        lblBanHang = new JLabel(new ImageIcon("image/ManagerUI/lblBanHang.png"));
        lblSanPham = new JLabel(new ImageIcon("image/ManagerUI/lblSanPham.png"));
        lblNhanVien = new JLabel(new ImageIcon("image/ManagerUI/lblNhanVien.png"));
        lblKhachHang = new JLabel(new ImageIcon("image/ManagerUI/lblKhachHang.png"));

        listMenuLeft = new ArrayList<>();
        listMenuLeft.add(lblBanHang);
        listMenuLeft.add(lblSanPham);
        listMenuLeft.add(lblNhanVien);
        listMenuLeft.add(lblKhachHang);

        for (JLabel lbl : listMenuLeft) {
            lbl.setVisible(false);
            lbl.setPreferredSize(new Dimension(250, 65));
            lbl.setOpaque(true);
            lbl.setBackground(clLeftItem);
            lbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            pnMenuLeft.add(lbl);
        }

        lblBanHang.setBackground(clLeftItemSelected);
        lblBanHang.setVisible(true);

        pnMain.add(pnMenuLeft, BorderLayout.WEST);

        /*
        ============================================================
                                CARD PANEL           
        ============================================================
         */
        pnCard = new JPanel(cardMenuLeftGroup);

        pnBanHang = new JPanel();
        pnSanPham = new JPanel();
        pnNhanVien = new JPanel();
        pnKhachHang = new JPanel();

        pnCard.add(pnBanHang, "1");
        pnCard.add(pnSanPham, "2");
        pnCard.add(pnNhanVien, "3");
        pnCard.add(pnKhachHang, "4");

        //==========ADD PANEL BÁN HÀNG =========
        banHangPanel = new PnQuanLyBanHangGUI();
        pnBanHang.setLayout(new BorderLayout());
        pnBanHang.add(banHangPanel, BorderLayout.CENTER);


        sanPhamPanel = new PnQuanLySanPhamGUI();
        pnSanPham.setLayout(new BorderLayout());
        pnSanPham.add(sanPhamPanel, BorderLayout.CENTER);
        lblSanPham.setVisible(true);

        nhanVienPanel = new PnQuanLyNhanVienGUI();
        pnNhanVien.setLayout(new BorderLayout());
        pnNhanVien.add(nhanVienPanel, BorderLayout.CENTER);
        lblNhanVien.setVisible(true);

        khachHangPanel = new PnQuanLyKhachHangGUI();
        pnKhachHang.setLayout(new BorderLayout());
        pnKhachHang.add(khachHangPanel, BorderLayout.CENTER);
        lblKhachHang.setVisible(true);


        pnMain.add(pnCard);
        /*
        ============================================================
                                CARD PANEL
        ============================================================
         */
        con.add(pnMain);
    }

    int xMouse, yMouse;

    private void addEvents() {
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                moverFrame(e.getXOnScreen(), e.getYOnScreen());
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                xMouse = e.getX();
                yMouse = e.getY();
            }
        });


        btnMinimize.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                thuNhoFrame();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnMinimize.setIcon(new ImageIcon("image/ManagerUI/btn-minimize--hover.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnMinimize.setIcon(new ImageIcon("image/ManagerUI/btn-minimize.png"));
            }
        });

        btnClose.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                thoatChuongTrinh();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnClose.setIcon(new ImageIcon("image/ManagerUI/btn-close--hover.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnClose.setIcon(new ImageIcon("image/ManagerUI/btn-close.png"));
            }
        });

        for (JLabel lbl : listMenuLeft) {
            lbl.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    for (JLabel lblDisable : listMenuLeft) {
                        lblDisable.setBackground(clLeftItem);
                    }
                    lbl.setBackground(clLeftItemSelected);

                    // Xử lý lật trang theo menu
                    String cardName = "";
                    if (lbl == lblBanHang) {
                        cardName = "1";
                    } else if (lbl == lblSanPham) {
                        cardName = "2";
                    } else if (lbl == lblNhanVien) {
                        cardName = "3";
                    } else if (lbl == lblKhachHang) {
                        cardName = "4";
                    } else {
                        cardName = "5";
                    }
                    cardMenuLeftGroup.show(pnCard, cardName);
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    if (lbl.getBackground().equals(clLeftItem)) {
                        lbl.setBackground(clLeftItemHover);
                    }
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (lbl.getBackground().equals(clLeftItemHover)) {
                        lbl.setBackground(clLeftItem);
                    }
                }
            });
        }

    }

    private void moverFrame(int x, int y) {
        this.setLocation(x - xMouse, y - yMouse);
    }

    private void thuNhoFrame() {
        this.setState(Frame.ICONIFIED);
    }

    private void thoatChuongTrinh() {
        banHangPanel.xuLyThoat();
        Main.Main.changLNF("Nimbus");
        System.exit(0);
    }

}
