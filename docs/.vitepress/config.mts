import { defineConfig } from 'vitepress'

// https://vitepress.dev/reference/site-config
export default defineConfig({
  title: "DS and Algo",
  description: "必知必会：数据结构与算法",
  themeConfig: {
    // https://vitepress.dev/reference/default-theme-config
    nav: [
      { text: '首页', link: '/' },
      { text: '阅读', link: '/getting-started' }
    ],
    search: {
      provider: 'local'
    },
    footer: {
      message: 'Released under the CC-BY-SA-4.0 license.',
      copyright: `Copyright © 2018-${new Date().getFullYear()} <a href="https://github.com/doocs">Doocs</a>`
    },
    logo: '/doocs.png',
    docFooter: {
      prev: '上一页',
      next: '下一页'
    },
    editLink: {
      pattern: 'https://github.com/doocs/data-structure-and-algorithm/edit/main/:path',
      text: '在 GitHub 编辑'
    },

    sidebar: [
      {
        text: '数据结构与算法',
        items: [
          { text: '数据结构的划分', link: '/linear-vs-nonlinear-data-structure.md' },
          { text: '稀疏矩阵和队列', link: '/the-introduction-to-sparse-matrix.md' },
          {
            text: '堆栈',
            collapsed: true,
            items: [
              { text: '堆栈', link: '/stack-introduction.md' },
              { text: '堆栈的实现', link: '' }
            ]
          },
          {
            text: '队列',
            collapsed: true,
            items: [
              { text: '队列介绍', link: '/queue-introduction.md' },
              { text: '队列的一个使用场景', link: '/queue-usage.md' },
              { text: '数组模拟队列的思路', link: '' },
              { text: '数组模拟环形队列', link: '' }
            ]
          },
          {
            text: '链表',
            collapsed: true,
            items: [
              { text: '链表介绍', link: '' },
              { text: '单链表应用实例', link: '' },
              { text: '单链表大厂面试题', link: '' },
              { text: '双向链表应用实例', link: '' },
              { text: '单向环形链表应用场景', link: '' },
              { text: '单向环形链表介绍', link: '' },
              { text: '约瑟夫问题', link: '' }
            ]
          },
          {
            text: '栈',
            collapsed: true,
            items: [
              { text: '栈的一个实际需求', link: '' },
              { text: '栈的介绍', link: '' },
              { text: '栈的应用场景', link: '' },
              { text: '栈的快速入门', link: '' },
              { text: '栈实现综合计算器', link: '' },
              { text: '逆波兰计算器', link: '' },
              { text: '中缀表达式转换为后缀表达式', link: '' }
            ]
          },
          {
            text: '递归',
            collapsed: true,
            items: [
              { text: '递归与递归调用机制', link: '' },
              { text: '递归-迷宫问题', link: '' },
              { text: '递归-八皇后问题（回溯算法）', link: '' }
            ]
          },
          {
            text: '排序算法',
            collapsed: true,
            items: [
              { text: '排序算法介绍', link: '' },
              { text: '算法的时空复杂度', link: '' },
              { text: '冒泡排序', link: '' },
              { text: '选择排序', link: '' },
              { text: '插入排序', link: '' },
              { text: '希尔排序', link: '' },
              { text: '快速排序', link: '' },
              { text: '归并排序', link: '' },
              { text: '基数排序', link: '' },
              { text: '常用排序算法对比总结', link: '' }
            ]
          },
          {
            text: '查找算法',
            collapsed: true,
            items: [
              { text: '线性查找算法', link: '' },
              { text: '二分查找算法', link: '' },
              { text: '插值查找算法', link: '' },
              { text: '斐波那契（黄金分割法）查找算法', link: '' }
            ]
          },
          {
            text: '哈希表',
            collapsed: true,
            items: [
              { text: '哈希表的基本介绍', link: '' },
              { text: 'Google 公司的一个上机题', link: '' }
            ]
          },
          {
            text: '树结构',
            collapsed: true,
            items: [
              { text: '二叉树', link: '' },
              { text: '顺序存储二叉树', link: '' },
              { text: '线索化二叉树', link: '' }
            ]
          },
          {
            text: '树结构应用',
            collapsed: true,
            items: [
              { text: '堆排序', link: '' },
              { text: '赫夫曼树', link: '' },
              { text: '赫夫曼编码', link: '' },
              { text: '二叉排序树', link: '' },
              { text: '平衡二叉树（AVL 树）', link: '' }
            ]
          },
          {
            text: '多路查找树',
            collapsed: true,
            items: [
              { text: '二叉树与 B 树', link: '' },
              { text: 'B 树、B+ 树和 B* 树', link: '' }
            ]
          },
          {
            text: '图',
            collapsed: true,
            items: [
              { text: '图基本介绍', link: '' },
              { text: '图的表示方式', link: '' },
              { text: '图的深度优先遍历', link: '' },
              { text: '图的广度优先遍历', link: '' },
              { text: '图的深度优先 VS 广度优先', link: '' }
            ]
          },
          {
            text: '10 大常用算法',
            collapsed: true,
            items: [
              { text: '二分查找算法（非递归）', link: '' },
              { text: '分治算法', link: '' },
              { text: '动态规划算法', link: '' },
              { text: 'KMP 算法', link: '' },
              { text: '贪心算法', link: '' },
              { text: '普里姆算法', link: '' },
              { text: '克鲁斯卡尔算法', link: '' },
              { text: '迪杰斯特拉算法', link: '' },
              { text: '弗洛伊德算法', link: '' },
              { text: '马踏棋盘算法', link: '' }
            ]
          }
        ]
      }
    ],

    socialLinks: [
      { icon: 'github', link: 'https://github.com/doocs/data-structure-and-algorithm' }
    ]
  },
  head: [
    ['link', { rel: 'icon', type: 'image/png', href: '/favicon-32x32.png' }],
  ],
  cleanUrls: true,
  sitemap: {
    hostname: 'https://dsa.doocs.org'
  }
})
